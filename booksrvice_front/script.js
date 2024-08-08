'use strict';

//Define elements
const btnSearch = document.querySelector('.btn--search');
const inputSearch = document.querySelector('.input--field');

const bookTitle = document.querySelector('.book--title');
const bookAuthor = document.querySelector('.book--author');
const bookPublisher = document.querySelector('.book--publisher');
const bookIsbn = document.querySelector('.book--isbn');

document.addEventListener('DOMContentLoaded', function () {
  fetchAllBooks('');
});

document.getElementById('serchBtn').addEventListener('click', function () {
  const query = document.getElementById('inputField').value;
  fetchBookById(query);
});

function fetchAllBooks() {
  fetch(`http://localhost:8080/api/book/data/get-all`)
    .then((response) => response.json())
    .then((data) => {
      displayBooks(data);
    })
    .catch((error) => console.error(error));
}

function fetchBookById(query) {
  fetch(`http://localhost:8080/api/book/data/${query}`)
    .then((response) => response.json())
    .then((data) => {
      displayBooks(data);
    })
    .catch((error) => console.error(error));
}

function displayBooks(books) {
  const tableContainer = document.getElementById('table-container');
  tableContainer.innerHTML = '';

  if (books.lenght === 0) {
    tableContainer.innerHTML = '<p>No books found.<p>';
    return;
  }

  const table = document.createElement('table');
  const thead = document.createElement('thead');
  const tbody = document.createElement('tbody');

  table.classList.add('center');

  const headers = ['ID', 'Title', 'Author', 'ISBN', 'Publisher'];
  const tr = document.createElement('tr');
  headers.forEach((header) => {
    const th = document.createElement('th');
    th.textContent = header;
    tr.appendChild(th);
  });
  thead.appendChild(tr);
  table.appendChild(thead);

  books.forEach((book) => {
    const tr = document.createElement('tr');

    const idCell = document.createElement('td');
    idCell.textContent = book.id;
    tr.appendChild(idCell);

    const titleCell = document.createElement('td');
    titleCell.textContent = book.title;
    tr.appendChild(titleCell);

    const authorCell = document.createElement('td');
    authorCell.textContent = book.author;
    tr.appendChild(authorCell);

    const isbnCell = document.createElement('td');
    isbnCell.textContent = book.isbn;
    tr.appendChild(isbnCell);

    const publisherCell = document.createElement('td');
    publisherCell.textContent = book.publisher;
    tr.appendChild(publisherCell);

    tbody.appendChild(tr);
  });

  table.appendChild(tbody);
  tableContainer.appendChild(table);
}
