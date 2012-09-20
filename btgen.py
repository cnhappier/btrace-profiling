############################################################
# Used to generate the btrace script from the given configuration
# and a known template
#
#   > btgen.py listmonitor.json
#
#   Refer to the Template comments for related Json Configure file Format
# ----------------------------------
############################################################
import json
import sys

## 1. Check Input Value: json configuration file name
############################################################
args = sys.argv
confFileName = ""
if len(args) < 2:
    print "The configure file name argument is needed"
    print "Command Format is:"
    print "   > btraceGenerator.py <Json Configure File Name>"
    exit()
else:
    confFileName = args[1]

## 2. Open configuration files 
############################################################
confJson  = json.load(file(confFileName))
confKeys  = confJson["replacement-map-list"]
confClass = confJson["monitor-class"]

## 3. Read in the template file
############################################################
templateFile = open(confJson["template-file-name"], 'r')
dictTpl = {}

while True:
    line = templateFile.readline()
    while line and ( (line.find("<<--") <0) or (line.find(" BEGIN-->>") <0) ):
        line = templateFile.readline()
    if not line:
        break

    key = line[line.find("<<--") + 4: line.find(" BEGIN-->>")]
    
    line = templateFile.readline()
    lines = []
    while line and (line.find("<<--") <0) and (line.find(" END-->>") <0):
        lines.append(line)
        line = templateFile.readline()
    
    if not line or (key != line[line.find("<<--") + 4: line.find(" END-->>")]):
        print "Template Format Error: <<--XXXX BEGIN-->> & <<--XXX END-->> must appear in pairs..."
        print "Please check line: ", line
        exit()

    dictTpl[key] = lines

templateFile.close()

## 4. Generate the new script file
############################################################
contents = []

# --> Class Definition Head
if dictTpl.has_key("Class Definition Head"):
    for line in dictTpl["Class Definition Head"]:
        newLine = line
        for key in confClass:
            newLine = newLine.replace(confKeys[key], str(confClass[key]))
        contents.append(newLine)
else:
    print "Template Format Error: "
    print "    <<--Class Definition Head BEGIN-->> ... <<--Class Definition Head END-->> must exist"
    exit()

for target in confJson["monitor-targets"]:
    if (not target.has_key("naming-suffix")) and target.has_key("display-name"):
        target["naming-suffix"]=target["display-name"].replace(" ", "")


# --> Display Interval
if dictTpl.has_key("Display Interval Head"):
    contents.extend(dictTpl["Display Interval Head"])

    # --> Save Value
    if dictTpl.has_key("Display Interval Save Value"):
        for target in confJson["monitor-targets"]:
            for line in dictTpl["Display Interval Save Value"]:
                newLine = line;
                for key in target:
                    newLine = newLine.replace(confKeys[key], str(target[key]))
                contents.append(newLine)

    # --> Print Value
    if dictTpl.has_key("Display Interval Print Value"):
        for target in confJson["monitor-targets"]:
            for line in dictTpl["Display Interval Print Value"]:
                newLine = line;
                for key in target:
                    newLine = newLine.replace(confKeys[key], str(target[key]))
                contents.append(newLine)
            
    # --> Tail
    if dictTpl.has_key("Display Interval Tail"):
        contents.extend(dictTpl["Display Interval Tail"])
    else:
        print "Template Format Error: "
        print "    The *Display Interval Head* and *Display Interval Tail* must appear in pairs"
        exit()

# --> Trace Method Body
if dictTpl.has_key("Trace Method Body"):
    for target in confJson["monitor-targets"]:
        for line in dictTpl["Trace Method Body"]:
            newLine = line;
            for key in target:
                newLine = newLine.replace(confKeys[key], str(target[key]))
            contents.append(newLine)

# --> Class Definition Tail
if dictTpl.has_key("Class Definition Tail"):
    for line in dictTpl["Class Definition Tail"]:
        newLine = line
        for key in confClass:
            newLine = newLine.replace(confKeys[key],     str(confClass[key]))
        contents.append(newLine)
else:
    print "Template Format Error: "
    print "    <<--Class Definition Tail BEGIN-->> ... <<--Class Definition Tail END-->> must exist"
    exit()

genFileName = confClass["gen-script-class-name"] + ".java"
genFile = file("./scripts/" + genFileName, "w")
genFile.writelines(contents)
