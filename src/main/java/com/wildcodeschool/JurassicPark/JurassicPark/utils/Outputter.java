package com.wildcodeschool.JurassicPark.JurassicPark.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildcodeschool.JurassicPark.JurassicPark.entities.Dinosaur;
import com.wildcodeschool.JurassicPark.JurassicPark.repositories.DinosaurDao;


@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wilder");

    @Autowired
    private DinosaurDao dinosaurDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + dinosaurDao.count());

        // Crée un nouveau dinosaure et l'enregistre dans la BDD
        Dinosaur tRex = new Dinosaur("T-Rex", "Black", 1);
        LOG.info("******************");
        LOG.info(tRex + " has been created !");
        dinosaurDao.save(tRex);
        LOG.info(tRex + " has been saved !");

        // Crée un second dinosaure et l'enregistre dans la BDD
        Dinosaur brachiosaurus = new Dinosaur("Brachiosaurus", "Grey", 6);
        LOG.info("******************");
        LOG.info(brachiosaurus + " has been created !");
        dinosaurDao.save(brachiosaurus);
        LOG.info(brachiosaurus + " has been saved !");

        // Lit les informations correspondant au second dinosaure et les affiche
        Dinosaur anonymousDinosaur = dinosaurDao.findById(2L).get();
        LOG.info("******************");
        LOG.info("Second dinosaur's Race is " + anonymousDinosaur.getRace());
        LOG.info("Second dinosaur's Color is " + anonymousDinosaur.getColor());
        LOG.info("They are " + anonymousDinosaur.getNbInPark() + " representants of this race in the Park");

        // Liste les dinosaures enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Dinosaurs in list are ");
        for(Dinosaur myDinosaur : dinosaurDao.findAll()) {
            LOG.info(myDinosaur.toString());
        };
       
       //Change la couleur du premier dinosaure (Udpate) 
       tRex.setColor("Pink");
       dinosaurDao.save(tRex);
       LOG.info("A dark " + dinosaurDao.findById(1L).get().getRace() + " was too much frightening ! We painted it in " + dinosaurDao.findById(1L).get().getColor());
        

        // Supprime le second dinosaure de la BDD
        dinosaurDao.deleteById(2L);

        /*     Liste les utilisateurs enregistrés dans la BDD
             (permet de vérifier que le second utilisateur
             a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Dinosaurs in list are ");
        for(Dinosaur myDinosaur : dinosaurDao.findAll()) {
            LOG.info(myDinosaur.toString());
        };
    }    
}
