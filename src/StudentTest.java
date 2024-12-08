import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Stdent> list = new ArrayList<>() ;
        loop :while (true) {
            System.out.println("----------------欢迎来到银河学生管理系统----------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            System.out.println("请输入您的选择");
            Scanner sc = new Scanner(System.in);
            String choose =sc.next();//
            switch (choose) {
                case "1":
                    addStudent(list);
                    //System.out.println("1:添加学生");
                    break;
                case "2":
                    deleteStudent(list);
                    //System.out.println("2:删除学生");
                    break;
                case "3":
                    updateStudent(list);
                    //System.out.println("3:修改学生");
                    break;
                case "4":
                    queryStudent(list);
                    //System.out.println("4:查询学生");
                    break;
                case "5" :
                            System.out.println("5:退出");
                            //退出方式
                            break loop;         //退出 loop  的循环
                            //System.exit(status 0);//停止虚拟机运行
                            //return;   //直接函数返回
                default:
                    System.out.println("没有这个选项");
                    break;
            }
        }
    }

    //添加学生
    private static void addStudent(ArrayList<Stdent> list) {
        //利用空参构造创建学生对象
        Stdent s = new Stdent();
        Scanner sc = new Scanner(System.in);
        String id;
        //添加学生ID
        while (true) {
            System.out.println("请输入学生的ID");
            id = sc.next();
            if (contains(list, id)) {
                System.out.println("ID已经存在，请重新录入");
                continue;
            }
            break;
        }
            s.setId(id);
        System.out.println("请输入学生的姓名");
        String name = sc.next();
        s.setName(name);
        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        s.setAge(age);
        System.out.println("请输入学生的住址");
        String address = sc.next();
        s.setAddress(address);

        list.add(s);
        System.out.println("学生信息添加成功");
    }
    //修改学生
    private static void updateStudent(ArrayList<Stdent> list) {
        Scanner sc = null;
        String str = null;
        int index = 0;
        while (true) {
            System.out.println("请输入你要修改的学生ID");
            sc = new Scanner(System.in);
            str = sc.next();
            index = getIndx(list, str);
            if (index < 0) {
                System.out .println("修改失败，该学生ID号不存在，请重新输入");
                continue;
            }
            break;
        }

        System.out.println("id\t姓名\t年龄\t家庭住址");
        System.out.println(list.get(index).getId()+"\t"+list.get(index).getName()+"\t"+list.get(index).getAge()+"\t"+list.get(index).getAddress());

        while (true) {
            System.out.println("请输入修改后的ID");
            str = sc.next();
            if (contains(list, str)) {
                System.out.println("ID已经存在，请重新录入");
                continue;
            }
            break;
        }
        list.get(index).setId(str);
        System.out.println("请输入修改后的姓名");
        String newname = sc.next();
        list.get(index).setName(newname);
        System.out.println("请输入修改后的年龄");
        int age = sc.nextInt();
        list.get(index).setAge(age);
        System.out.println("请输入修改后的住址");
        String address = sc.next();
        list.get(index).setAddress(address);

        System.out.println("修改成功");
    }


    //删除学生
    private static void deleteStudent(ArrayList<Stdent> list) {
        System.out.println("请输入要删除的ID");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int indx = getIndx(list, id);
        //判断ID是否存在
        if(indx<0) {
            System.out .println("删除失败，该学生ID号不存在");
            return;
        }
        list.remove(indx);
        System.out.println("改名学生已被删除");
    }
    //查询学生
    private static void queryStudent(ArrayList<Stdent> list) {
        if(list.size() == 0){
            System.out.println("当前无学生信息，请先添加学生信息！");
            return;
        }
        //打印表头性息
        System.out.println("id\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Stdent stu = list.get(i);
            System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
        }
    }
    //查询学生中是否有 相同ID
    private static boolean contains(ArrayList<Stdent> list,String ID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(ID)) {
                return true;
            }
        }
        return false;
    }
    //获取学生信息
    private static int getIndx(ArrayList<Stdent> list,String ID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(ID)) {
                return i;
            }
        }
        return -1;//查询失败
    }
}

