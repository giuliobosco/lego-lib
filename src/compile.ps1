# create the folder for the compiled classes
mkdir .\out\

# compile all the classes
nxjc .\*.java -d .\out\

# switch to the compiled classes directory
cd out

# link the compiled classes to a nxj file
nxjlink -o .\Test.nxj UseWaitTimeSynchron