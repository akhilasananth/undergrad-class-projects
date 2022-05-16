package springexample.mainDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * Created by akhilaananth on 2/2/2017.
 */

@Controller
public class BuddyInfoController {
    @Autowired
    private BuddyInfoRepository buddyRep;

    @RequestMapping("/buddyInfo")
    public String buddyInfo(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "buddyInfo";
    }

    @GetMapping("/buddyInfo")
    public String greetingForm(Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "buddyInfo";
    }

    @PostMapping("/buddyInfo")
    public String buddyInfoSubmit(@ModelAttribute BuddyInfo buddy) {
        buddyRep.save(buddy);
        return "result";
    }

    @GetMapping("/buddyList")
    public String buddyInfoSubmit(Model model) {
        String allBuddies = "";
        Iterator it = buddyRep.findAll().iterator();
        while(it.hasNext()) {
            allBuddies += it.next().toString()+"\n";
        }
        model.addAttribute("allBuddies",allBuddies);
        return "BuddyList";
    }

}
