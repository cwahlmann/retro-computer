10 MODE 2
20 LINE 0,HEIGHT()/2 TO WIDTH()-1,HEIGHT()/2
30 LINE WIDTH()/2,0 TO WIDTH()/2,HEIGHT()-1
40 Y0=HEIGHT()/2:I0=0
50 FOR I=0 TO WIDTH() STEP 10
60 Y=SIN(PI*2*I/WIDTH())*HEIGHT()/2+HEIGHT()/2
70 LINE I0,Y0 TO I,Y:I0=I:Y0=Y
80 NEXT
90 GOTO 90
