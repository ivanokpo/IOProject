'use strict';

const baseURL = "http://localhost:8081";


const getAllDogs = () => {
    axios.get(`${baseURL}/listDogs`)
        .then(res => {
            const dogs = res.data;
            getAllOutput.innerHTML = "";
            dogs.forEach(dog => renderDog(dog));
        }).catch(err => console.log(err));

}

const getAllOutput = document.querySelector("#outputDiv");
const getByIdOutput = document.querySelector("#getByIdOutput");

const renderDog = (dog) => {

    const dogColumn = document.createElement('div');
    dogColumn.classList.add("col");

    const dogCard = document.createElement('div');
    dogCard.classList.add("card");
    dogColumn.appendChild(Card);





    const newDog = document.createElement('div');

    newDog.classList.add("card-body");


    const newDogName = document.createElement("h2");
    newDogName.innerText = `Name: ${dog.name}`;
    dogName.classList.add("card-title");
    newDog.appendChild(newDogName);

    const newDogAge = document.createElement("p");
    newDogAge.innerText = `Age: ${dog.age}`;
    dogAge.classList.add("card-text");
    newDog.appendChild(newDogAge);


    const newDogColour = document.createElement("p");
    newDogColour.innerText = `Colour: ${dog.colour}`; 
    dogAge.classList.add("card-text");
    newDog.appendChild(newDogColour);

    const deleteButton = document.createElement('button');
    deleteButton.innerText = "DELETE";

    deleteButton.addEventListener('click', () => deleteDog(dog.id));
    
    newDog.appendChild(deleteButton);

    dogCard.appendChild(newDog);

    outputDiv.appendChild(dogColumn);

    // outputDiv.appendChild(newDog);

}

const DogId = document.querySelector("#DogId");

const deleteDog = id => {
    axios.delete(`${baseURL}/deleteDog/${id}`)
        .then(res => {
            console.log(res);
            getAllDogs();
        }).catch(err => console.log(err));
}



const getDogId = () => {


    axios.get(`${baseURL}/getDogId/${DogId.value}`)
        .then(res => {
            const dog = res.data;
            getByIdOutput.innerHTML = "";
            renderDog(dog, getByIdOutput);
            renderDog(dog);
        }).catch(err => console.log(err));



}

const complete = () => {
    alert(`Request Complete`);
} 

document.querySelector("section#getById > button").addEventListener('click', getDogId);

document.querySelector("section#postSection > form").addEventListener('submit', (e) => {
    e.preventDefault(); // stops the form submitting in the default way

    console.log("THIS: ", this);
    console.log("NAME: ", this.name);

    const form = e.target;

    const data = {
        name: form.name.value,

        age: form.age.value,

        colour: form.colour.value
    }

    console.log("DATA: ", data);

    axios.post(`${baseURL}/createDog`, data)
        .then((res) => {
            console.log(res);
            getAllDogs();
            complete();

            form.reset(); //resets form
            form.name.focus(); // selects the name input
        }).catch(err => console.log(err));
});


getAllDogs();





