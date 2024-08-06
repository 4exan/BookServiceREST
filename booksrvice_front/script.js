'use strict';

//Define elements
const btnSearch = document.querySelector('.btn--search');
const inputSearch = document.querySelector('.input--field');

const bookTitle = document.querySelector('.book--title');
const bookAuthor = document.querySelector('.book--author');
const bookPublisher = document.querySelector('.book--publisher');
const bookIsbn = document.querySelector('.book--isbn');

btnSearch.addEventListener('click', function () {
  fetch(`http://localhost:8080/api/book/data/${inputSearch.value}`)
    .then((response) => response.json())
    .then((data) => {
      console.log(`Title: ${data.title}, Author: ${data.author}`);
    })
    .catch((error) => console.error(error));
});
