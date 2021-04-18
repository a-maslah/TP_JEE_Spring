package enset.sping.tp2.web;

import enset.sping.tp2.entites.Patient;
import enset.sping.tp2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PatientController {

        @Autowired
        private PatientRepository patientRep;

        @GetMapping("/")
        public String index(){
            return "template";
        }

        @GetMapping(path="/patients")
        public String listePatients(Model model, @RequestParam(name= "page", defaultValue = "0")int page,
                                    @RequestParam(name= "size", defaultValue = "5")int size,
                                    @RequestParam(name="keyword",defaultValue="")String mc){
            Page<Patient> patients= patientRep.findByNomContains(mc, PageRequest.of(page,size));
            model.addAttribute("listePatients",patients.getContent());
            model.addAttribute("pages",new int[patients.getTotalPages()]);
            model.addAttribute("currentPage", page);
            model.addAttribute("keyword", mc);
            model.addAttribute("size", size);
            return "patients";
        }

        @GetMapping(path="/deletePatient")
        public String delete(Long id,String keyword,int page,int size) {

            patientRep.deleteById(id);
            return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
        }
        @GetMapping(path="/deletePatient2")
        public String delete2(Long id,String keyword,int page,int size,Model model) {
            patientRep.deleteById(id);
            return listePatients(model,page,size,keyword);
        }

        @GetMapping(path="/formPatient")
        public String formPatient(Model model){
          model.addAttribute("patient",new Patient());
model.addAttribute("mode","new");
           return "formPatient";
        }

      
       @PostMapping(path="/savePatient")
       public String savePatient(@Valid Patient patient, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "formPatient";
         patientRep.save(patient);
         return "formPatient";
        }
        @GetMapping(path="/editPatient")
        public String editPatient(Model model,Long id){
          Patient p = patientRep.findById(id).get();
          model.addAttribute("patient",p);
         model.addAttribute("mode","edit");
           return "formPatient";
        }

    }

