package dev.practice.ad.interfaces.web;

import dev.practice.ad.application.AppFacade;
import dev.practice.ad.domain.app.AppCommand;
import dev.practice.ad.domain.app.AppInfo;
import dev.practice.ad.interfaces.web.form.AppForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/app")
public class AppController {

    private final AppFacade appFacade;


    @GetMapping
    public String listApps(Model model){
        log.info("{listApps} list app ");
        List<AppInfo> result = appFacade.listApp();
        for (AppInfo appInfo : result) {
            log.info(appInfo.toString());
        }
        model.addAttribute("apps", result);
        return "app/listApp";
    }

    @GetMapping("/new")
    public String viewInsertApp(Model model){
        model.addAttribute("appKey", "adfadfasf");
        return "app/createAppForm";
    }


    @PostMapping("/new")
    public String insertAppId(AppForm form, Model model){

        log.info("{insertAppId} appId: "+ form.getAppId());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        AppCommand appCommand = form.toCommand();
        log.info("appCommand {}", appCommand);
        appFacade.registerApp(appCommand);

        model.addAttribute("appKey", "adfadfasf");

        return "app/createAppForm";
    }

    @GetMapping("/{id}")
    public String detailApp(@PathVariable Long id, Model model){
        AppInfo result = appFacade.getAppById(id);

        model.addAttribute("app", result);
        return "app/detailApp";
    }

}
