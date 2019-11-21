package cc.popkorn.example;

import cc.popkorn.PopKornCompat;
import cc.popkorn.example.model.D10;
import cc.popkorn.example.model.R1i;
import cc.popkorn.example.model.R2i;
import cc.popkorn.example.model.R3i;
import cc.popkorn.example.model.R4i;
import cc.popkorn.example.model.R5i;
import cc.popkorn.example.model.R6i;
import cc.popkorn.example.model.R7i;
import cc.popkorn.example.model.R8i;

public class ExampleCompat {

    void execute(){
        D10 d10 = new D10();
        PopKornCompat.addInjectable(d10);

        PopKornCompat.inject(R1i.class);
        PopKornCompat.inject(R2i.class);
        PopKornCompat.inject(R3i.class);
        PopKornCompat.inject(R4i.class,"envX");
        PopKornCompat.inject(R5i.class);
        PopKornCompat.inject(R6i.class);
        PopKornCompat.inject(R7i.class);
        PopKornCompat.inject(R8i.class);
        PopKornCompat.inject(R8i.class,"env1");
        PopKornCompat.inject(R8i.class,"env2");
        PopKornCompat.inject(R8i.class,"env3");
        PopKornCompat.inject(R8i.class,"env4");

        PopKornCompat.removeInjectable(D10.class);
        PopKornCompat.reset();

        System.out.println("ok compat");
    }

}
