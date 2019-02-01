# create the folder for the compiled classes
mkdir .\out\

# compile all the classes
nxjc .\WaitTime.java -d .\out\
nxjc .\UseWaitTime.java -d .\out\


# switch to the compiled classes directory
cd out

# link the compiled classes to a nxj file
nxjlink -o .\Test.nxj UseWaitTime

nxjupload -r Test.nxj