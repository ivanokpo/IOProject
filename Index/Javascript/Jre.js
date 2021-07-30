'use strict';

const baseURL = "http://localhost:8080";

const getAllOutput = document.querySelector("#outputDiv");

const getPodcasts = () => {
    axios.get(`${baseURL}/podcasts`)
        .then(res => {
            const podcasts = res.data;
            getAllOutput.innerHTML = "";
            podcasts.forEach(joe => renderPodcast(joe, getAllOutput));
        }).catch(err => console.log(err));

}



const getByOutput = document.querySelector("#getByIdOutput");

const renderPodcast = (joe, outputDiv) => {

    
    
    const podColumn = document.createElement('div');
    podColumn.classList.add("col");
    podColumn.classList.add("card-deck");


    const podCard = document.createElement('div');
    podCard.classList.add("card");
 

    podColumn.appendChild(podCard);





    const newPod = document.createElement('div');
    newPod.classList.add("card-body");


    const newPodNumb = document.createElement("h2");
    newPodNumb.innerText = `Number: ${joe.podcastNumber}`;
    newPodNumb.classList.add("card-title");
    newPod.appendChild(newPodNumb);


    const newPodGuest = document.createElement("p");
    newPodGuest.innerText = `Guests: ${joe.guests}`;
    newPodGuest.classList.add("card-text");
    newPod.appendChild(newPodGuest);


    const newPodCat = document.createElement("p");
    newPodCat.innerText = `Category: ${joe.category}`;
    newPodCat.classList.add("card-text");
    newPod.appendChild(newPodCat);




    const newPodRating = document.createElement("p");
    newPodRating.innerText = `Rating: ${joe.rating}`;
    newPodRating.classList.add("card-text");
    newPod.appendChild(newPodRating);



    const newPodFav = document.createElement("p");
    newPodFav.innerText = `Favorite: ${joe.favorite}`;
    newPodFav.classList.add("card-text");
    newPod.appendChild(newPodFav);

    const deleteButton = document.createElement('button');
    deleteButton.innerText = "DELETE";
    deleteButton.classList.add("btn", "btn-danger");
    
    deleteButton.addEventListener('click', () => deletePodcast(joe.id));

    newPod.appendChild(deleteButton);

    podCard.appendChild(newPod);
    const spaces = document.createElement('br');
    outputDiv.appendChild(spaces);

    outputDiv.appendChild(podColumn);

    

    const categoryimage = () => {
        if (joe.category === "comedy") {
            console.log("hi");
            const img = document.createElement("img");
            img.src = "https://images.pexels.com/photos/713149/pexels-photo-713149.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260";
            img.classList.add("card-img-top");
            newPod.appendChild(img);


        } else if (joe.category === "war") {

            const img = document.createElement("img");
            img.src = "https://images.pexels.com/photos/87772/soldiers-military-usa-weapons-87772.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260";
            img.classList.add("card-img-top");
            newPod.appendChild(img);

        } else if (joe.category === "mma") {

            const img = document.createElement("img");
            img.src = "https://images.pexels.com/photos/6295866/pexels-photo-6295866.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260";
            img.classList.add("card-img-top");
            newPod.appendChild(img);

        } else if (joe.category === "psychology") {

            const img = document.createElement("img");
            img.src = "https://images.pexels.com/photos/289586/pexels-photo-289586.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260";
            img.classList.add("card-img-top");
            newPod.appendChild(img);

        }

        else if (joe.category === "hunting") {

            const img = document.createElement("img");
            img.src = "https://images.pexels.com/photos/4830337/pexels-photo-4830337.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260";
            img.classList.add("card-img-top");
            newPod.appendChild(img);

        }
    }

    categoryimage();

    
}

const PodId = document.querySelector("#podId");


const deletePodcast = id => {
    axios.delete(`${baseURL}/deletePodcast/${id}`)
        .then(res => {
            console.log(res);
            getPodcasts();
        }).catch(err => console.log(err));
}



const getPodId = () => {


    axios.get(`${baseURL}/getPodcastId/${PodId.value}`)
        .then(res => {
            const joe = res.data;
            getByOutput.innerHTML = "";
            renderPodcast(joe, getByOutput);
            // renderPodcast(joe);
        }).catch(err => console.log(err));



}

const complete = () => {
    alert(`Request Complete`);
}

document.querySelector("section#getById > button").addEventListener('click', getPodId);

document.querySelector("section#postSection > form").addEventListener('submit', (e) => {
    e.preventDefault(); // stops the form submitting in the default way

    console.log("THIS: ", this);
    console.log("NAME: ", this.name);

    const form = e.target;

    const data = {
        podcastNumber: form.number.value,

        guests: form.guests.value,

        category: form.category.value,

        rating: form.rating.value,

        favorite: form.favorite.value
    }

    console.log("DATA: ", data);

    axios.post(`${baseURL}/createPodcast`, data)
        .then((res) => {
            console.log(res);

            complete();

            form.reset(); //resets form
            form.number.focus(); // selects the number input
        }).catch(err => console.log(err));
});



document.querySelector("section#updateSection > form").addEventListener('submit', (e) => {
    e.preventDefault(); // stops the form submitting in the default way

    console.log("THIS: ", this);
    console.log("NAME: ", this.name);

    const form = e.target;
    const id = form.id.value;
    const data = {



        podcastNumber: form.number.value,

        guests: form.guests.value,

        category: form.category.value,

        rating: form.rating.value,

        favorite: form.favorite.value
    }

    console.log("DATA: ", data);

    axios.put(`${baseURL}/updatePodcast/${id}`, data)
        .then((res) => {
            console.log(res);

            complete();

            form.reset(); //resets form
            form.number.focus(); // selects the number input
        }).catch(err => console.log(err));
});



getPodcasts();

//working
