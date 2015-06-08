clc

x=-10:1:53;
y=fun(x);
plot(x,y)
grid on

xmin =  fminbnd(@fun,20,30)
ymin = fun(xmin)

x=20:1:30;
y=fun(x);
figure
plot(x,y)
grid on

xmax=fminbnd(@fun1,5,15)
ymax=-fun1(xmax)

x=5:1:15;
y=fun(x);
figure
plot(x,y)
grid on