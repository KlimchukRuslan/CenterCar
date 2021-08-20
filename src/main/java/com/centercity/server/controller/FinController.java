package com.centercity.server.controller;

import com.centercity.server.entity.FinDataUser;
import com.centercity.server.entity.FinDateAndWeek;
import com.centercity.server.entity.User;
import com.centercity.server.service.FinService;
import com.centercity.server.service.FinServiceDate;
import com.centercity.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FinController {
    @Autowired
    UserService userService;
    @Autowired
    FinService finService;

    @Autowired
    FinServiceDate finServiceDate;

    @GetMapping("/fin_edit")
    public String fin_edit(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("allUser", users);
        model.addAttribute("tmp_fin_date",finServiceDate.getByID(1));
        model.addAttribute("date",(finServiceDate.getByID(1).getDate()));
        String isShow = "Нет";
        if (finServiceDate.getByID(1).isShow()){
            isShow = "Да";
        }
        model.addAttribute("show", isShow);

        return "fin/get_users";
    }
    //Страница информации для сотрудника
    @GetMapping("/get_user_fin")
    public String fin_user(Model model , HttpServletRequest request) {
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        FinDataUser fin_data = new FinDataUser();
        FinDateAndWeek fin_tmp_date = finServiceDate.getByID(1);

        List<FinDataUser> fin_list = finService.getAll();
        for (FinDataUser fu : fin_list) {
            if (fu.getDriver_code().equals(authUser.getDriver_code())){
                fin_data = fu;
            }
        }
        double sum = 0;
        if (fin_data.getSum_val_dop_d_top() != null && !(fin_data.getSum_val_dop_d_top().equals(""))) {
            sum = Double.parseDouble(fin_data.getSum_val_dop_d_top());
            sum = sum / 2;
        }
        model.addAttribute("raz_sum", sum);

        if (fin_tmp_date.isShow()){

            model.addAttribute("fin_tmp_date", fin_tmp_date);
            model.addAttribute("FinData", fin_data);
            model.addAttribute("name", authUser.getUsername());

            try{
                if (!(fin_data.getPereplata_nal().equals(""))){
                    model.addAttribute("pereplata", " <tr>\n" +
                            "        <td class=\"cell1\">+ переплата:</td>\n" +
                            "        <td class=\"cell2\">"+fin_data.getPereplata_nal()+" грн</td>\n" +
                            "      </tr>");
                }

                if (!(fin_data.getSum_bonus().equals(""))){
                    model.addAttribute("bonus", "<tr>\n" +
                            "        <td class=\"cell1\">+ бонусы за "+fin_data.getBonus()+":</td>\n" +
                            "        <td class=\"cell2\">"+fin_data.getSum_bonus()+" грн</td>\n" +
                            "      </tr>");
                }

                if (!(fin_data.getPred_week().equals(""))){
                    model.addAttribute("pereneseno", "<tr>\n" +
                            "        <td class=\"cell1\">+ перенесено с предыдущей недели:</td>\n" +
                            "        <td class=\"cell2\">"+fin_data.getPred_week()+" грн</td>\n" +
                            "      </tr>");
                }

                if (!(fin_data.getPererashod().equals(""))){
                    model.addAttribute("pererazhod", "<tr>\n" +
                            "        <td class=\"cell1\">- перерасход топлива:</td>\n" +
                            "        <td class=\"cell2\">"+fin_data.getPererashod()+" грн</td>\n" +
                            "      </tr>");
                }

                if (!(fin_data.getNedosdacha().equals(""))){
                    model.addAttribute("nedozdacha", "<tr>\n" +
                            "        <td class=\"cell1\">- недосдача:</td>\n" +
                            "        <td class=\"cell2\">"+fin_data.getNedosdacha()+" грн</td>\n" +
                            "      </tr>");
                }

                if (!(fin_data.getMoyka().equals(""))){
                    model.addAttribute("moyka", "<tr>\n" +
                            "        <td class=\"cell1\">- мойка авто:</td>\n" +
                            "        <td class=\"cell2\">"+fin_data.getMoyka()+" грн</td>\n" +
                            "      </tr>");
                }

                if (!(fin_data.getAvans().equals(""))){
                    model.addAttribute("avans", "<tr>\n" +
                            "        <td class=\"cell1\">- аванс: "+fin_data.getDate_avans()+" </td>\n" +
                            "        <td class=\"cell2\">"+fin_data.getAvans()+" грн</td>\n" +
                            "      </tr>");
                }

                if (!(fin_data.getVyplaty().equals(""))){
                    model.addAttribute("vyplata", "<tr>\n" +
                            "        <td class=\"cell1\">- выплаты: "+fin_data.getData_vyplaty()+"</td>\n" +
                            "        <td class=\"cell2\">"+fin_data.getVyplaty()+" грн</td>\n" +
                            "      </tr>");
                }

                if (!(fin_data.getSum_drugoe().equals(""))){
                    model.addAttribute("drugoe", "<tr>\n" +
                            "        <td class=\"cell1\">- другое: "+fin_data.getDrugoe()+"</td>\n" +
                            "        <td class=\"cell2\">"+fin_data.getSum_drugoe()+" грн</td>\n" +
                            "      </tr>");
                }

                return "user/fin_page";
            }catch (NullPointerException e){
                System.out.println("Ошибка отображени данных" + e );
                return "user/no_fin_data";
            }
        }
        return "user/no_fin_data";
    }


    @PostMapping("/get_user_fin_id")
    public String fin_user_id(Model model, Long id) {
        User authUser = userService.findUserById(id);
        FinDataUser fin_data = new FinDataUser();
        List<FinDataUser> fin_list = finService.getAll();
        for (FinDataUser fu : fin_list) {
            if (fu.getDriver_code().equals(authUser.getDriver_code())){
                fin_data = fu;
            }
        }
        double sum = 0;
        if (fin_data.getSum_val_dop_d_top() != null && !(fin_data.getSum_val_dop_d_top().equals(""))) {
            sum = Double.parseDouble(fin_data.getSum_val_dop_d_top());
            sum = sum / 2;
        }
        model.addAttribute("raz_sum", sum);


        if (fin_data.isShow()){
            model.addAttribute("FinData", fin_data);
            model.addAttribute("name", authUser.getUsername());

            if (!(fin_data.getPereplata_nal().equals(""))){
                model.addAttribute("pereplata", " <tr>\n" +
                        "        <td class=\"cell1\">+ переплата:</td>\n" +
                        "        <td class=\"cell2\">"+fin_data.getPereplata_nal()+" грн</td>\n" +
                        "      </tr>");
            }

            if (!(fin_data.getSum_bonus().equals(""))){
                model.addAttribute("bonus", "<tr>\n" +
                        "        <td class=\"cell1\">+ бонусы за "+fin_data.getBonus()+":</td>\n" +
                        "        <td class=\"cell2\">"+fin_data.getSum_bonus()+" грн</td>\n" +
                        "      </tr>");
            }

            if (!(fin_data.getPred_week().equals(""))){
                model.addAttribute("pereneseno", "<tr>\n" +
                        "        <td class=\"cell1\">+ перенесено с предыдущей недели:</td>\n" +
                        "        <td class=\"cell2\">"+fin_data.getPred_week()+" грн</td>\n" +
                        "      </tr>");
            }

            if (!(fin_data.getPererashod().equals(""))){
                model.addAttribute("pererazhod", "<tr>\n" +
                        "        <td class=\"cell1\">- перерасход топлива:</td>\n" +
                        "        <td class=\"cell2\">"+fin_data.getPererashod()+" грн</td>\n" +
                        "      </tr>");
            }

            if (!(fin_data.getNedosdacha().equals(""))){
                model.addAttribute("nedozdacha", "<tr>\n" +
                        "        <td class=\"cell1\">- недосдача:</td>\n" +
                        "        <td class=\"cell2\">"+fin_data.getNedosdacha()+" грн</td>\n" +
                        "      </tr>");
            }

            if (!(fin_data.getMoyka().equals(""))){
                model.addAttribute("moyka", "<tr>\n" +
                        "        <td class=\"cell1\">- мойка авто:</td>\n" +
                        "        <td class=\"cell2\">"+fin_data.getMoyka()+" грн</td>\n" +
                        "      </tr>");
            }

            if (!(fin_data.getAvans().equals(""))){
                model.addAttribute("avans", "<tr>\n" +
                        "        <td class=\"cell1\">- аванс: "+fin_data.getDate_avans()+" </td>\n" +
                        "        <td class=\"cell2\">"+fin_data.getAvans()+" грн</td>\n" +
                        "      </tr>");
            }

            if (!(fin_data.getVyplaty().equals(""))){
                model.addAttribute("vyplata", "<tr>\n" +
                        "        <td class=\"cell1\">- выплаты: "+fin_data.getData_vyplaty()+"</td>\n" +
                        "        <td class=\"cell2\">"+fin_data.getVyplaty()+" грн</td>\n" +
                        "      </tr>");
            }

            if (!(fin_data.getSum_drugoe().equals(""))){
                model.addAttribute("drugoe", "<tr>\n" +
                        "        <td class=\"cell1\">- другое: "+fin_data.getDrugoe()+"</td>\n" +
                        "        <td class=\"cell2\">"+fin_data.getSum_drugoe()+" грн</td>\n" +
                        "      </tr>");
            }

            return "user/fin_page";
        }
        return "user/no_fin_data";
    }


    //Мапинг для изминения дат выплат
    @PostMapping("/fin_edit_date")
    public String fin_edit_date(@RequestParam(required = true, defaultValue = "" ) String  vyplata, String week, String dates1, String dates2, boolean check_show, Model model) {

        FinDateAndWeek finDate = finServiceDate.getByID(1);
        finDate.setDate(getParseDate(vyplata));
        finDate.setWeek(week);
        finDate.setDates(dates1+" - "+getParseDate(dates2));
        finDate.setShow(check_show);
        finServiceDate.updateDate(finDate);

        return fin_edit(model);
    }

    @PostMapping("/fin_edit")
    public String fin_edit_user(@RequestParam(required = true, defaultValue = "" ) Long userId, Model model , HttpServletRequest request) {
        FinDataUser new_fin_data = new FinDataUser();

        User user = userService.findUserById(userId);

        List <FinDataUser> finDataUsersList = finService.getAll();

        for (FinDataUser fd : finDataUsersList) {
            if (fd.getDriver_code().equals(user.getDriver_code())){
                model.addAttribute("finForm", fd);
                model.addAttribute("user", user);

                return "fin/fin_edit_user";
            }
        }
        new_fin_data.setDriver_code(user.getDriver_code());
        finService.save(new_fin_data);
        fin_edit_user(userId, model, request);
        return "fin/new_string";
    }

    @PostMapping("/fin_add_data")
    public String fin_edit_user(@ModelAttribute("finForm") @Valid FinDataUser finForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
//            Переделать страницу ошибки
            return "transfer/error";
        }

        if (finService.validForm(finForm)==0){
            finService.updateFin(finForm);
        }

        return "fin/ok";
    }

    public String getParseDate(String date){

        Date parsed = null;
        try {
            parsed = new SimpleDateFormat("yyyy-MM-dd").parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String str = simpleDateFormat.format(parsed);
        return str;
    }

}
