package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository=inhousePartRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        OutsourcedPart PA98= new OutsourcedPart();
        OutsourcedPart EZ98= new OutsourcedPart();
        OutsourcedPart ReStringZero= new OutsourcedPart();
        OutsourcedPart SuperGrap= new OutsourcedPart();
        InhousePart RacketBag = new InhousePart();
        if (outsourcedPartRepository.count() == 0) {
            PA98.setCompanyName("Babolat");
            PA98.setName("Pure Aero 98");
            PA98.setInv(5);
            PA98.setPrice(289.99);
            outsourcedPartRepository.save(PA98);

            EZ98.setCompanyName("Yonex");
            EZ98.setName("EZONE 98");
            EZ98.setInv(5);
            EZ98.setPrice(304.99);
            outsourcedPartRepository.save(EZ98);

            ReStringZero.setCompanyName("ReString");
            ReStringZero.setName("ReString Zero Tennis String Set");
            ReStringZero.setInv(5);
            ReStringZero.setPrice(14.00);
            outsourcedPartRepository.save(ReStringZero);

            SuperGrap.setCompanyName("Yonex");
            SuperGrap.setName("Yonex Super Grap Overgrip");
            SuperGrap.setInv(5);
            SuperGrap.setPrice(8.00);
            outsourcedPartRepository.save(SuperGrap);

            RacketBag.setName("Racket Bag");
            RacketBag.setInv(5);
            RacketBag.setPrice(44.99);




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
