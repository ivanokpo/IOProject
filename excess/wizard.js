'use strict' ;

let firstname = "ivan";
let secondname ="okpomor";

let starsign = "aries";

let myTxt = "So many styles";

console.log(firstname);
console.log(secondname);

console.log(starsign);
console.log("%c" + myTxt,"color: orange; font-family:fantasy; font-style:bold; background-color:black; padding: 10px")
let dinnercost = 72;
let moneypaid = 50;
let moneyleft = dinnercost - moneypaid;
console.log("Dinner cost £"+ dinnercost+", However you only paid £"+moneypaid+ " so far, therefore you owe £" + moneyleft);

for (let i = 100 ; i < 201; i++){
        if(i < 201){
            console.log(`A =${i}`);
        } else {
            console.log("End.");
        }
    }

//ORRRR

let a = 100;
while (a <= 200) {
  a++;
  console.log(`a = ${a}`);
}

for(let i = 100 ; i <= 200 ; i++){
    if(i % 2 === 0){
        console.log(`${i} = -`)
    } else{
        console.log(`${i} =`)
    }
}

for(let i = 1; i <= 10 ; i++){
    for(let j = 1; j <= 10 ; j++){
        console.log( `${i}`);

    }
    }

let age = 50
let result = age >= 50 ? "50 or over" : "Under 50";
console.log(result)

const darthVader = {

    allegiance:"empire",
    weapon:"lightsabre",
    sith:true,
    jedi:false
}

console.log(darthVader)
console.log(`Darth Vaders allegiance is to the ${darthVader.allegiance}`);
console.log(`Darth Vaders weapon of choice is ${darthVader.weapon}`);
if(darthVader.sith === true){
    console.log(`He's a sith? ${darthVader.sith}`)
    console.log(`He's a jedi? ${darthVader.jedi}`)
    //ORRRR
    console.log(`Darth Vader is a jedi? ${darthVader.sith ? "false":"true"}`)
}

const myArray = ["hello", "everyone"];
console.log(myArray.length);
console.log(myArray.push("My","Name","is","Ivan"));
console.log(myArray.length);
myArray.shift();
for (let i = 0; i < myArray.length; i++) {
    console.log(myArray[i]);
 }

 function doSomething(){
     let x = 'foo';
     if(x.length < 4){
        let y = 'too small';
         console.log(`${x} is ${y}`)
     }
console.log(x);
console.log(y);

 }

function welcome(name,age,gender){
    console.log(`my name is ${name}, i am currently ${age} years old, i identify as ${gender}`);
}

const powerUp = (a,b) => Math.pow(a,b);


const censor = words => {
    const filtered = [];
    for(let i = 0; i < words.length; i++) {
        const word = words[i];
        if(word.length !== 4) filtered.push(word);
    }
    return filtered;
};

//example of a higher order function

const reduce = (reducer, initial, arr) =>{
    //shared stuff
    let acc = initial;

    for(let i=0; i<arr.length; i++) {
        //unique stuff in reducer() call
        acc = reducer(acc,arr[i]);

        // more shared stuff
    }
    return acc;
}
// this sets out the structure of reduce function

reduce((acc,curr) => acc + curr,0,[1,2,3]);

let grades = [
    {name: 'John', grade: 8, sex: 'M'},
    {name: 'Sarah', grade: 12, sex: 'F'},
    {name: 'Bob', grade: 16, sex: 'M'},
    {name: 'Johnny', grade: 2, sex: 'M'},
    {name: 'Cyrus', grade: 4, sex: 'M'},
    {name: 'Paula', grade: 18, sex: 'F'},
    {name: 'Jeff', grade: 5, sex: 'M'},
    {name: 'Jennifer', grade: 13, sex: 'F'},
    {name: 'Courtney', grade: 15, sex: 'F'},
    {name: 'Jane', grade: 9, sex: 'F'}
]
//defining boys and girls
let isBoy = student => student.sex === "M";
let isGirl = student => student.sex === "F";

//working out boys grades
let getBoys = grades => (grades.filter(isBoy));
let getGirls = grades => (grades.filter(isGirl));

//working out average

let average = grades => (grades.reduce((acc,curr) => (acc + curr.grade), 0) / grades.length);

//working max and min grades
let maxGrade = grades => (Math.max(...grades.map(student => student.grade)));
let minGrade = grades => (Math.min(...grades.map(student => student.grade)));


let classroomMax = maxGrade(grades);

let classroomMaxBoy = maxGrade(grades.filter(isBoy));
//OR
let classroomMaxBoy2 = maxGrade(getBoys(grades));


const num1 = document.querySelector("#num1");
const num2 = document.querySelector("#num2");
const answer = document.querySelector("#answer");
const buttons = document.querySelectorAll("section#calculator")
const history = document.querySelector("#history");


const calculate = (e) => {
    const operator = e.target.innerText;

    switch (operator) {
        case 'C':
            num1.value = "0";
            num2.value = "0";
            answer.value = "0";
            break;
        case '+':
            answer.value = Number.parseFloat(num1.value) + Number.parseFloat(num2.value);
            history.value = eval(answer.value = Number.parseFloat(num1.value) + Number.parseFloat(num2.value))
            break;
        case '-':
            answer.value = Number.parseFloat(num1.value) - Number.parseFloat(num2.value);
            break;
        case '*':
            answer.value = Number.parseFloat(num1.value) * Number.parseFloat(num2.value);
            break;
        case '/':
            answer.value = Number.parseFloat(num1.value) / Number.parseFloat(num2.value);
            break;
    }
}

//listening method, which removes need for html

buttons.forEach(button => button.addEventListener('click', calculate));


const baseURL = "http://localhost:8080";



axios.get(`${baseURL}/listDogs`)
    .then(res => {
        const dogs = res.data;

        dogs.forEach(dog => renderDog(dog));
    }).catch(err => console.log(err));


const renderDog = (dog) => {
    const newDogName = document.createElement('p');
    
    newDogName.textContent = dog.name;

    getAllSection.appendChild(newDogName);

    const newDogAge = document.createElement('p');

    newDogAge.textContent = dog.age;

    getAllSection.appendChild(newDogAge);

    const newDogColour = document.createElement('p');

    newDogColour.textContent = dog.colour;

    getAllSection.appendChild(newDogColour)
}











