package com.centercity.server.tls;

public class MailHtml {

       public String getMailText(){
           String mail ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" +
                   "<html style=\"width:100%;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">" +
                   "<head>" +
                   "<meta charset=\"UTF-8\">" +
                   "<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">" +
                   "<meta name=\"x-apple-disable-message-reformatting\">" +
                   "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
                   "<meta content=\"telephone=no\" name=\"format-detection\">" +
                   "<title>Сообщение</title>" +
                   "<!--[if (mso 16)]>" +
                   "<style type=\"text/css\">" +
                   "a {text-decoration: none;}" +
                   "</style>" +
                   "<![endif]-->" +
                   "<!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->" +
                   "<!--[if !mso]><!-- -->" +
                   "<link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,700,700i\" rel=\"stylesheet\">" +
                   "<!--<![endif]-->" +
                   "<style type=\"text/css\">" +
                           "@media only screen and (max-width:600px) {.st-br { padding-left:10px!important; padding-right:10px!important } p, ul li, ol li, a { font-size:16px!important; line-height:150%!important } h1 { font-size:30px!important; text-align:center; line-height:120%!important } h2 { font-size:24px!important; text-align:center; line-height:120%!important } h3 { font-size:20px!important; text-align:center; line-height:120%!important } h1 a { font-size:30px!important; text-align:center } h2 a { font-size:24px!important; text-align:center } h3 a { font-size:20px!important; text-align:center } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:14px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } a.es-button { font-size:16px!important; display:block!important; border-left-width:0px!important; border-right-width:0px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } .es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } })" +
                           ".rollover:hover .rollover-first {" +
                           "max-height:0px!important;" +
                           "display:none!important;" +
                                   "}" +
                                   ".rollover:hover .rollover-second {" +
                                   "max-height:none!important;" +
                                   "display:block!important;" +
                                   "}" +
                   "#outlook a {" +
                           "padding:0;" +
                           "}" +
                           ".ExternalClass {" +
                           "width:100%;" +
                           "}" +
                           ".ExternalClass," +
                           ".ExternalClass p," +
                           ".ExternalClass span," +
                           ".ExternalClass font," +
                           ".ExternalClass td," +
                           ".ExternalClass div {" +
                           "line-height:100%;" +
                                   "}" +
                   ".es-button {" +
                           "mso-style-priority:100!important;" +
                           "text-decoration:none!important;" +
                   "}" +
                   "a[x-apple-data-detectors] {" +
                           "color:inherit!important;" +
                           "text-decoration:none!important;" +
                           "font-size:inherit!important;" +
                           "font-family:inherit!important;" +
                           "font-weight:inherit!important;" +
                           "line-height:inherit!important;" +
                   "}" +

                   ".es-desk-hidden {" +
                           "display:none;" +
                           "float:left;" +
                           "overflow:hidden;" +
                           "width:0;" +
                           "max-height:0;" +
                           "line-height:0;" +
                           "mso-hide:all;" +
                   "}" +

                   ".es-button-border:hover {" +
                       "border-style:solid solid solid solid!important;" +
                       "background:#d6a700!important;" +
                       "border-color:#42d159 #42d159 #42d159 #42d159!important;" +
                   "}" +

                   ".es-button-border:hover a.es-button {" +
                       "background:#d6a700!important;" +
                       "border-color:#d6a700!important;" +
                   "}" +

"</style> " +
   "</head> " +
       "<body style=\"width:100%;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">" +
   "<div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6;\">" +
   "<!--[if gte mso 9]>" +
        "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">" +
           "<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>" +
        "</v:background>" +
   "<![endif]-->" +
   "<table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;\"> " +
        "<tr style=\"border-collapse:collapse;\"> " +
            "<td class=\"st-br\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
               "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                       "<td align=\"center\" style=\"padding:0;Margin:0;background-image:url(https://hfecyr.stripocdn.email/content/guids/CABINET_10c8a4b90e25cfa9ce9c9396c9af24b6/images/20841560930387653.jpg);background-color:transparent;background-position:center bottom;background-repeat:no-repeat;\" bgcolor=\"transparent\" background=\"https://hfecyr.stripocdn.email/content/guids/CABINET_10c8a4b90e25cfa9ce9c9396c9af24b6/images/20841560930387653.jpg\"> " +
                   "<!--[if gte mso 9]><v:rect xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\" style=\"mso-width-percent:1000;height:204px;\"><v:fill type=\"tile\" src=\"https://pics.esputnik.com/repository/home/17278/common/images/1546958148946.jpg\" color=\"#343434\" origin=\"0.5, 0\" position=\"0.5,0\" ></v:fill><v:textbox inset=\"0,0,0,0\"><![endif]--> " +
                       "<div> " +
                           "<table bgcolor=\"transparent\" class=\"es-header-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\"> " +
                               "<tr style=\"border-collapse:collapse;\"> " +
                                    "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;\"> " +
                                        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                                            "<tr style=\"border-collapse:collapse;\"> " +
                                                "<td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                                                    "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">" +
                                                        "<tr style=\"border-collapse:collapse;\"> " +
                                                            "<td align=\"center\" height=\"65\" style=\"padding:0;Margin:0;\"></td> " +
                                                        "</tr> " +
                                                    "</table></td>" +
                                                "</tr>" +
                                            "</table></td> " +
                                        "</tr> " +
                                    "</table> " +
                       "</div> " +
           "<!--[if gte mso 9]></v:textbox></v:rect><![endif]--></td> " +
           "</tr> " +
               "</table> " +
           "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> " +
               "<tr style=\"border-collapse:collapse;\">" +
                   "<td align=\"center\" bgcolor=\"transparent\" style=\"padding:0;Margin:0;background-color:transparent;\">" +
                       "<table bgcolor=\"transparent\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\"> " +
                           "<tr style=\"border-collapse:collapse;\">" +
                               "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:30px;padding-left:30px;padding-right:30px;border-radius:10px 10px 0px 0px;background-color:#FFFFFF;background-position:left bottom;\" bgcolor=\"#ffffff\"> " +
                                    "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                                        "<tr style=\"border-collapse:collapse;\"> " +
                                            "<td width=\"540\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                                                "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-position:left bottom;\" role=\"presentation\"> " +
                                                    "<tr style=\"border-collapse:collapse;\"> " +
                                            "<td align=\"center\" style=\"padding:0;Margin:0;\"><h1 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#212121;\">Предача автомобиля</h1></td> " +
                                        "</tr> " +
                                        "<tr style=\"border-collapse:collapse;\">" +
                               "<td align=\"center\" style=\"padding:0;Margin:0;padding-top:20px;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:28px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:42px;color:#131313;\">АА7540ВР</p></td> " +
                               "</tr>" +
                           "</table></td> " +
                            "</tr> " +
                       "</table></td> " +
               "</tr>" +
               "<tr style=\"border-collapse:collapse;\"> " +
               "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:30px;padding-left:30px;padding-right:30px;border-radius:10px 10px 0px 0px;background-color:#FFFFFF;background-position:left bottom;\" bgcolor=\"#ffffff\"> " +
                "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                 "<tr style=\"border-collapse:collapse;\"> " +
                   "<td width=\"540\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                     "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-position:left bottom;\" role=\"presentation\"> " +
                       "<tr style=\"border-collapse:collapse;\"> " +
                         "<td align=\"center\" style=\"padding:0;Margin:0;\"><h1 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#212121;\">Сдает:</h1></td> " +
                        "</tr> " +
                        "<tr style=\"border-collapse:collapse;\"> " +
                        "<td align=\"center\" style=\"padding:0;Margin:0;padding-top:20px;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:28px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:42px;color:#131313;\">ФИО</p></td> " +
                       "</tr> " +
                     "</table></td> " +
                   "</tr> " +
                 "</table></td> " +
                "</tr> " +
           "<tr style=\"border-collapse:collapse;\"> " +
               "<td align=\"left\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:30px;padding-right:30px;border-radius:0px 0px 10px 10px;background-position:left top;background-color:#FFFFFF;\"> " +
                "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                       "<td width=\"540\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                               "<tr style=\"border-collapse:collapse;\"> " +
                                    "<td align=\"left\" style=\"padding:0;Margin:0;\"> " +
                                        "<div style=\"text-align:center;font-size:30px;\"> " +
                                        "<br> " +
                               "</div></td> " +
                           "</tr> " +
                       "</table></td> " +
                   "</tr> " +
               "</table></td> " +
           "</tr> " +
           "<tr style=\"border-collapse:collapse;\"> " +
               "<td align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:20px;padding-right:20px;background-position:left bottom;\"> " +
                   "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                       "<tr style=\"border-collapse:collapse;\"> " +
                           "<td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                               "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                                    "<tr style=\"border-collapse:collapse;\"> " +
                           "<td align=\"center\" style=\"padding:0;Margin:0;\"><h3 style=\"Margin:0;line-height:30px;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:20px;font-style:normal;font-weight:normal;color:#212121;\">Проверьте комплектацию и при согласии передайте код</h3></td> " +
                       "</tr> " +
                      "</table></td> " +
                    "</tr> " +
                   "</table></td> " +
                 "</tr> " +
               "</table></td> " +
           "</tr> " +
       "</table> " +
   "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> " +
       "<tr style=\"border-collapse:collapse;\"> " +
           "<td align=\"center\" style=\"padding:0;Margin:0;\"> " +
               "<table bgcolor=\"transparent\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                        "<td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;background-position:left bottom;\"> " +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                                "<tr style=\"border-collapse:collapse;\"> " +
                                    "<td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                                        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                                            "<tr style=\"border-collapse:collapse;\"> " +
                                                "<td align=\"center\" height=\"30\" style=\"padding:0;Margin:0;\"></td> " +
                                                    "</tr> " +
                                        "</table></td> " +
                                    "</tr> " +
                                "</table></td> " +
                            "</tr> " +
                        "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"left\" style=\"Margin:0;padding-bottom:10px;padding-top:30px;padding-left:30px;padding-right:30px;border-radius:10px 10px 0px 0px;background-color:#FFFFFF;\" bgcolor=\"#ffffff\"> " +
               "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                        "<td width=\"540\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                                "<tr style=\"border-collapse:collapse;\"> " +
                                    "<td align=\"left\" style=\"padding:0;Margin:0;\"><h1 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#212121;text-align:center;\">" +
                   //КОМПЛЕКТАЦИЯ
                   "Комплектация</h1></td> " +
                                "</tr> " +
                            "</table></td> " +
                        "</tr> " +
                   "</table></td> " +
               "</tr> " +

                "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"left\" style=\"Margin:0;padding-top:5px;padding-bottom:20px;padding-left:30px;padding-right:30px;border-radius:0px 0px 10px 10px;background-color:#FFFFFF;\" bgcolor=\"#ffffff\"> " +
                        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +

               "<tr style=\"border-collapse:collapse;\"> " +
                    "<td width=\"540\" align=\"left\" style=\"padding:0;Margin:0;\"> " +
                   "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\"><strong>" +
//                   ЗАПАСКА
                   "Запаска:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; Есть</strong></p></td> " +
                "</tr> " +

               "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0;\"> " +
                        "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                            "<tr style=\"border-collapse:collapse;\"> " +
                                "<td style=\"padding:0;Margin:0px;border-bottom:2px solid #CCCCCC;background:none;height:1px;width:100%;margin:0px;\"></td> " +
                            "</tr> " +
                        "</table>" +
                   "</td> " +
               "</tr> " +

               "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\">" +
                   //Домкрат
                   "<strong>Домкрат:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Есть</strong></p>" +
                   "</td> " +
               "</tr> " +

               "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0;\"> " +
                        "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
               "<tr style=\"border-collapse:collapse;\"> " +
                   "<td style=\"padding:0;Margin:0px;border-bottom:2px solid #CCCCCC;background:none;height:1px;width:100%;margin:0px;\"></td> " +
               "</tr> " +
                        "</table></td> " +
               "</tr> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\"><strong>" +
//             Огнетушитель
                   "Огнетушитель:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Есть</strong></p></td> " +
                   "</tr> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0;\"> " +
                   "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +

                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td style=\"padding:0;Margin:0px;border-bottom:2px solid #CCCCCC;background:none;height:1px;width:100%;margin:0px;\"></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +

                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\"><strong>" +
//                   Балонный ключ:
                    "Балонный ключ:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;Есть</strong></p></td> " +
                   "</tr> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0;\"> " +
                   "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td style=\"padding:0;Margin:0px;border-bottom:2px solid #CCCCCC;background:none;height:1px;width:100%;margin:0px;\"></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +

                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\"><strong>" +
//                   Буксировочный трос:
                   "Буксировочный трос:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;Есть</strong></p></td> " +
                   "</tr> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0;\"> " +
                   "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\">" +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td style=\"padding:0;Margin:0px;border-bottom:2px solid #CCCCCC;background:none;height:1px;width:100%;margin:0px;\"></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +

                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\"><strong>" +
//                   Жилетка:
                   "Жилетка:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp; Есть</strong></p></td> " +
                   "</tr> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0;\"> " +
                   "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td style=\"padding:0;Margin:0px;border-bottom:2px solid #CCCCCC;background:none;height:1px;width:100%;margin:0px;\"></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\"><strong>" +
//                   Аптечка:
                   "Аптечка:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Есть</strong></p></td> " +
                   "</tr> " +

                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0;\"> " +
                   "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td style=\"padding:0;Margin:0px;border-bottom:2px solid #CCCCCC;background:none;height:1px;width:100%;margin:0px;\"></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\"><strong>" +
//                   Буксировочный крюк:
                   "Буксировочный крюк:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Есть</strong></p></td> " +
                   "</tr> " +

                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0;\"> " +
                   "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td style=\"padding:0;Margin:0px;border-bottom:2px solid #CCCCCC;background:none;height:1px;width:100%;margin:0px;\"></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +

                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\"><strong>" +
//                   Противооткат:
                   "Противооткат:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Есть</strong></p></td> " +
                   "</tr> " +

                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0;\"> " +
                   "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td style=\"padding:0;Margin:0px;border-bottom:2px solid #CCCCCC;background:none;height:1px;width:100%;margin:0px;\"></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:20px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:30px;color:#131313;\"><strong>" +
//             Знак аварийки:
                   "Знак аварийки:&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Есть</strong></p></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"left\" style=\"padding:0;Margin:0;background-position:left bottom;\"> " +
                   "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td width=\"600\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                   "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-position:left bottom;\" role=\"presentation\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                   "<td align=\"center\" height=\"40\" style=\"padding:0;Margin:0;\"></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +
                   "</table></td> " +
                   "</tr> " +

       "<tr style=\"border-collapse:collapse;\"> " +
           "<td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;background-position:left bottom;\"> " +
               "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                        "<td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-position:left bottom;\" role=\"presentation\"> " +
                                "<tr style=\"border-collapse:collapse;\"> " +
                                "<td align=\"center\" height=\"40\" style=\"padding:0;Margin:0;\"></td> " +
                                "</tr> " +
                            "</table></td> " +
                   "</tr> " +
               "</table></td> " +
            "</tr> " +
        "</table></td> " +
           "</tr> " +
   "</table> " +

   "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:#F6F6F6;background-repeat:repeat;background-position:center top;\"> " +
       "<tr style=\"border-collapse:collapse;\"> " +
           "<td align=\"center\" style=\"padding:0;Margin:0;background-image:url(https://hfecyr.stripocdn.email/content/guids/CABINET_10c8a4b90e25cfa9ce9c9396c9af24b6/images/31751560930679125.jpg);background-position:left bottom;background-repeat:no-repeat;\" background=\"https://hfecyr.stripocdn.email/content/guids/CABINET_10c8a4b90e25cfa9ce9c9396c9af24b6/images/31751560930679125.jpg\"> " +
               "<table bgcolor=\"#31cb4b\" class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                        "<td align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:30px;padding-right:30px;background-color:#FAFAFA;border-radius:10px 10px 0px 0px;\" bgcolor=\"#fafafa\"> " +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                                "<tr style=\"border-collapse:collapse;\"> " +
                                    "<td width=\"540\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                                "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                            "<tr style=\"border-collapse:collapse;\"> " +
                        "<td align=\"center\" style=\"padding:0;Margin:0;\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:30px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:45px;color:#131313;\"><strong>" +
//      КОД
                   "Ваш код - 1258</strong></p></td> " +
                   "</tr> " +
               "</table></td> " +
           "</tr> " +
       "</table></td>" +
       "</tr> " +

       "<tr style=\"border-collapse:collapse;\"> " +
           "<td style=\"Margin:0;padding-top:10px;padding-bottom:20px;padding-left:30px;padding-right:30px;background-position:left top;background-color:#FAFAFA;\" align=\"left\" bgcolor=\"#fafafa\"> " +
               "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                        "<td width=\"540\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;\"> " +
                            "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                                "<tr style=\"border-collapse:collapse;\"> " +
                                "<td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:10px;\"><h2 style=\"Margin:0;line-height:29px;mso-line-height-rule:exactly;font-family:tahoma, verdana, segoe, sans-serif;font-size:24px;font-style:normal;font-weight:bold;color:#212121;\">Уведомление!!!</h2>Передавая код который используется для отправки Вы соглашаетесь с тем что принял Ваш напарник.<br></td> " +
                                "</tr> " +
                            "</table>" +
                        "</td> " +
                    "</tr> " +
               "</table>" +
           "</td> " +
        "</tr>" +

       "<tr style=\"border-collapse:collapse;\"> " +
           "<td align=\"left\" style=\"padding:0;Margin:0;background-position:left top;\"> " +
               "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                   "<tr style=\"border-collapse:collapse;\"> " +
                        "<td width=\"600\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> " +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> " +
                            "<tr style=\"border-collapse:collapse;\"> " +
                        "<td align=\"center\" height=\"40\" style=\"padding:0;Margin:0;\"></td> " +
                   "</tr> " +
               "</table>" +
           "</td> " +
       "</tr> " +
   "</table></td> " +
                   "</tr> " +
               "</table></td> " +
           "</tr> " +
       "</table></td> " +
       "</tr> " +
   "</table>" +
  "</div>" +
 "</body>" +
"</html>";

           return mail;
       }

       public String getSmallMail(String driver_old, String driver_new, String car, String probeg,  String code){

           String str =
                   "Автомобиль  - "+car+"\n"+
                   "Сдает - "+driver_old+"\n"+
                   "Принимает - "+driver_new+"\n"+
                   "Пробег - "+probeg+"\n"+
                   "Код - "+code;

           return  str;
       }
}
