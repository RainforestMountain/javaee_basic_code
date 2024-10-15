var student = new Object(); // 和创建数组类似
student.name = "蔡徐坤";
student.height = 175;
student['weight'] = 170;
student.sayHello = function () {
    console.log("hello");
}
console.log(student.name);
console.log(student['weight']);
student.sayHello();
