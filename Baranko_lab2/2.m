[x1,x2] = meshgrid(-2.0:0.1:2.0);
Z =20 + exp(1) - 20 * exp(-0.2*((1/2)*(x1.^2 + x2.^2)).^0.5)-exp((1/2)*(cos(2*pi*x1)+cos(2*pi*x2)));;
mesh(Z)

x =  fminbnd(@fun2,-30.0,30.0)
y = fun2(x)