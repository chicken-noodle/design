package minqi.xiao.design.controller;

import minqi.xiao.design.dao.Dao;
import minqi.xiao.design.model.*;
import minqi.xiao.design.model.Character;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@org.springframework.stereotype.Controller
public class Controller {

    @Resource
    private Dao dao;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }

//    @ResponseBody
//    @RequestMapping("/exec")
//    public String exec(String code) throws InterruptedException, IOException {
//        code = "#include<cstdio>\n" +
//                "using namespace std;\n" +
//                "int main(){\n" +
//                "\tint a,b;\n" +
//                "\twhile(~scanf(\"%d%d\",&a,&b)){\n" +
//                "\tif(a==-1)\n" +
//                "\t\tbreak;\n" +
//                "\tprintf(\"%d\\n\",a+b);\n" +
//                "\t}\n" +
//                "\treturn 0;\n" +
//                "} ";
//        File file = new File("D:\\1.cpp");
//        StringBuffer stringBuffer = new StringBuffer(code);
//        //File file2 = new File("D:\\userAnswer.txt");
//        stringBuffer.insert(code.indexOf("{",code.indexOf("main()")) + 1, "freopen(\"in_1.txt\",\"r\",stdin);freopen(\"userAnswer.txt\",\"w\",stdout);");
//        File file3 = new File("D:\\1.bat");
//
//        //System.out.println(stringBuffer);
//        try {
//            file.createNewFile();
//            //file2.createNewFile();
//            FileWriter fileWriter = new FileWriter(file);
//            fileWriter.write(stringBuffer.toString());
//            fileWriter.close();
//            FileWriter fileWriter1 = new FileWriter(file3);
//            fileWriter1.write("@echo off \n" +
//                    "d:\n" +
//                    "1.exe\n" +
//                    "exit");
//            fileWriter1.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            Runtime runtime = Runtime.getRuntime();
//            Process process = runtime.exec("g++ D:/1.cpp -o D:/1.exe");
//            process.waitFor();
//            process.destroy();
//            File file1 = new File("D:/1.exe");
//            if(file1.exists()){
//                Process process1 = runtime.exec("d:/1.bat");
//                process1.waitFor();
//                process1.destroy();
//                file1.delete();
//            }
//
//            else{
//                System.out.print("编译出错，请检查语法！");
//            }
//            file3.delete();
//
//        }
//        return "true";
//    }


    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/number")
    public String memoryNumber() {
        return "memory_number";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/word")
    public String memoryWord() {
        return "memory_word";
    }

    @RequestMapping("/picture")
    public String memoryPicture() {
        return "memory_picture";
    }

    @RequestMapping("/character")
    public String memoryCharacter() {
        return "memory_character";
    }

    @RequestMapping("/poem")
    public String memoryPoem() {
        return "memory_poem";
    }

    @ResponseBody
    @RequestMapping("/postPicture")
    public String postPicture(){
        for(int i=0;i<50;i++){
            String uuid = UUID.randomUUID().toString();
            dao.postPictureUUID(uuid);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/getData")
    public String getData(Integer num, String type) {
        Random random = new Random();
        Vector<Integer> vector = new Vector<>();

        if (type.equals("word")) {
            List<Word> l = new ArrayList<>();
            int max_num = dao.getWordNum();
            while (num > 0) {
                Integer tmp = random.nextInt(max_num) + 1;
                if (!vector.contains(tmp)) {
                    vector.add(tmp);
                    num--;
                }
            }
            for (Integer integer : vector) {
                Word word = dao.getWordById(integer);
                l.add(word);
            }
            //System.out.println(l.toString());
            return l.toString();

        } else if (type.equals("character")) {
            List<Character> l = new ArrayList<>();
            int max_num = dao.getCharacterNum();
            while (num > 0) {
                Integer tmp = random.nextInt(max_num) + 1;
                if (!vector.contains(tmp)) {
                    vector.add(tmp);
                    num--;
                }
            }
            for (Integer integer : vector) {
                Character character = dao.getCharacterById(integer);
                l.add(character);
            }
            return l.toString();
        } else if (type.equals("poem")) {
            List<Poem> l = new ArrayList<>();
            int max_num = dao.getPoemNum();
            while (num > 0) {
                Integer tmp = random.nextInt(max_num) + 1;
                if (!vector.contains(tmp)) {
                    vector.add(tmp);
                    num--;
                }
            }
            //Collections.sort(vector);
            for (Integer integer : vector) {
                Poem poem = dao.getPoemById(integer);
                l.add(poem);
            }
            return l.toString();
        } else if(type.equals("picture")){
            List<Picture> l = new ArrayList<>();
            int max_num = dao.getPictureNum();
            //System.out.println(max_num);
            while (num > 0) {
                Integer tmp = random.nextInt(max_num) + 1;
                //System.out.println(tmp);
                if (!vector.contains(tmp)) {
                    vector.add(tmp);
                    num--;
                }else{
                    //System.out.println("呵呵");
                }
            }

            for (Integer integer : vector) {
                Picture picture = dao.getPictureById(integer);
                l.add(picture);
            }
            return l.toString();
        }

        else
            return "";
    }

    @RequestMapping("/register_check")
    public String registerCheck(User user,Model model) {

        int ans = dao.registerCheck(user);
        if(ans>0){
            model.addAttribute("tip","账号已存在，请重新注册");
            return "register";
        }

        dao.insertSelective(user);
        return "login";
    }

    @RequestMapping("/login_check")
    public String loginCheck(String username, String password, HttpServletRequest request, Model model) {
        List<User> users = dao.lognkCheck(username, password);
        if (users.size() < 1) {
            model.addAttribute("message","用户名或密码错误");
            return "login";
        } else {
            request.getSession().setAttribute("user", username);
            return "index";
        }
    }

    @ResponseBody
    @RequestMapping("/get_info")
    public String getInfo(HttpServletRequest request){
        String username = request.getSession().getAttribute("user") == null ? "":request.getSession().getAttribute("user").toString();
        if(username.equals("")){
            return "";
        }
        User user = dao.selectByUsername(username);
        return user.toString();
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "login";
    }








}
