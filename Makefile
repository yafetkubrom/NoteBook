major1: major1.o endian.o rotate.o parity.o clz.o
	gcc -Wall -o major1 major1.o endian.o rotate.o parity.o clz.o

major1.o: major1.c
	gcc -c major1.c
          
endian.o: endian.c
	gcc -c endian.c

rotate.o: rotate.c
	gcc -c rotate.c

clz.o: clz.c
	gcc -c clz.c

parity.o: parity.c
	gcc -c parity.c

clean:
	rm *.o
	rm major1
