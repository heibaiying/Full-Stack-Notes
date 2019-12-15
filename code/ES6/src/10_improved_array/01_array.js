let items = Array.of(1, 2);
console.log(items);

let numbers01 = Array.from([1, 2, 3, 4, 5], (value) => value * 10);
console.log(numbers01);


let numbers02 = [25, 30, 35, 40, 45];
console.log(numbers02.find(n => n > 33)); // 35
console.log(numbers02.findIndex(n => n > 33)); // 2


let numbers03 = [1, 2, 3, 4];
numbers03.fill(1);
console.log(numbers03.toString()); // 1,1,1,1

//指定位置
let numbers04 = [1, 2, 3, 4];
numbers04.fill(1, 2);
console.log(numbers04.toString()); // 1,2,1,1
numbers04.fill(0, 1, 3);
console.log(numbers04.toString()); // 1,0,0,1

let numbers05 = [1, 2, 3, 4];
// 从索引 2 的位置开始粘贴
// 从数组索引 0 的位置开始复制数据
numbers05.copyWithin(2, 0);
console.log(numbers05.toString()); // 1,2,1,2

let numbers06 = [1, 2, 3, 4];
// 从索引 2 的位置开始粘贴
// 从数组索引 0 的位置开始复制数据
// 在遇到索引 1 时停止复制
numbers06.copyWithin(2, 0, 1);
console.log(numbers06.toString()); // 1,2,1,4
