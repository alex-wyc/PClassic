#! /bin/bash

for file in $( ls *STUB* ); do
    mv -v $file $( ./remove-stub.sh $file )
done
