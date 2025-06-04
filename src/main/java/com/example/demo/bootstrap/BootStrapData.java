package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;


/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository,
                         OutsourcedPartRepository outsourcedPartRepository,
                         InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository=inhousePartRepository;

    }

    @Override
    public void run(String... args) throws Exception {



        if (outsourcedPartRepository.count() == 0 && inhousePartRepository.count() == 0
                && partRepository.count() == 0 && productRepository.count() == 0) {
            /* Start parts */
            OutsourcedPart PA98= new OutsourcedPart();
            OutsourcedPart EZ98= new OutsourcedPart();
            OutsourcedPart ReStringZero= new OutsourcedPart();
            OutsourcedPart SuperGrap= new OutsourcedPart();
            InhousePart RacketBag = new InhousePart();

            /* Start Products */
            Product PA98Setup = new Product();
            Product EZ98Setup = new Product();
            Product PA98SetupWithRacketBag = new Product();
            Product EZ98SetupWithRacketBag = new Product();
            Product StringGripCombo = new Product();

            /* Start parts initialization */
            PA98.setCompanyName("Babolat");
            PA98.setName("Babolat Pure Aero 98");
            PA98.setInv(5);
            PA98.setPrice(289.99);
            PA98.setMinInv(1);
            PA98.setMaxInv(5);
            outsourcedPartRepository.save(PA98);

            EZ98.setCompanyName("Yonex");
            EZ98.setName("Yonex EZONE 98");
            EZ98.setInv(5);
            EZ98.setPrice(304.99);
            EZ98.setMinInv(1);
            EZ98.setMaxInv(5);
            outsourcedPartRepository.save(EZ98);

            ReStringZero.setCompanyName("ReString");
            ReStringZero.setName("ReString Zero Tennis String Set");
            ReStringZero.setInv(5);
            ReStringZero.setPrice(14.00);
            ReStringZero.setMinInv(1);
            ReStringZero.setMaxInv(5);
            outsourcedPartRepository.save(ReStringZero);

            SuperGrap.setCompanyName("Yonex");
            SuperGrap.setName("Yonex Super Grap Overgrip");
            SuperGrap.setInv(5);
            SuperGrap.setPrice(8.00);
            SuperGrap.setMinInv(1);
            SuperGrap.setMaxInv(5);
            outsourcedPartRepository.save(SuperGrap);

            RacketBag.setName("Racket Bag");
            RacketBag.setInv(5);
            RacketBag.setPrice(44.99);
            RacketBag.setMinInv(1);
            RacketBag.setMaxInv(5);
            inhousePartRepository.save(RacketBag);

            /* Start products initialization */
            PA98Setup.setName("Babolat Pure Aero 98 Setup");
            PA98Setup.setInv(5);
            PA98Setup.setPrice(PA98.getPrice() + ReStringZero.getPrice() + SuperGrap.getPrice());
            productRepository.save(PA98Setup);

            EZ98Setup.setName("EZONE 98 Setup");
            EZ98Setup.setInv(5);
            EZ98Setup.setPrice(EZ98.getPrice() + ReStringZero.getPrice() + SuperGrap.getPrice());
            productRepository.save(EZ98Setup);

            PA98SetupWithRacketBag.setName("Babolat Pure Aero 98 Setup With Racket Bag");
            PA98SetupWithRacketBag.setInv(5);
            PA98SetupWithRacketBag.setPrice(PA98.getPrice() + ReStringZero.getPrice() + SuperGrap.getPrice() +
                    RacketBag.getPrice());
            productRepository.save(PA98SetupWithRacketBag);

            EZ98SetupWithRacketBag.setName("Yonex EZONE 98 Setup With Racket Bag");
            EZ98SetupWithRacketBag.setInv(5);
            EZ98SetupWithRacketBag.setPrice(EZ98.getPrice() + ReStringZero.getPrice() + SuperGrap.getPrice() +
                    RacketBag.getPrice());
            productRepository.save(EZ98SetupWithRacketBag);

            StringGripCombo.setName("String + Grip Combo");
            StringGripCombo.setInv(5);
            StringGripCombo.setPrice(ReStringZero.getPrice() + SuperGrap.getPrice() - 1);
            productRepository.save(StringGripCombo);


        }
//        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
//        for(OutsourcedPart part:outsourcedParts){
//            if(part.getName().equals("Pure Aero 98"))thePart=part;
//        }
//        System.out.println(thePart.getCompanyName());


//        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

//        System.out.println("Started in Bootstrap");
//        System.out.println("Number of Products"+productRepository.count());
//        System.out.println(productRepository.findAll());
//        System.out.println("Number of Parts"+partRepository.count());
//        System.out.println(partRepository.findAll());

    }
}

