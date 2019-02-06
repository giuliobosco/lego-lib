# create the folder for the compiled classes
mkdir .\out\

# compile all the classes
nxjc .\WaitLightSensor.java -d .\out\
nxjc .\SingleMotor.java -d .\out\
nxjc .\LineFollower.java -d .\out\
nxjc .\LFRunner.java -d .\out\


# switch to the compiled classes directory
cd out

# link the compiled classes to a nxj file
nxjlink -o .\Test.nxj LFRunner

nxjupload -r Test.nxj