import { useEffect, useState } from "react";

export default function MainPanel() {
  const [books, setBooks] = useState([]);
  const [active, setActive] = useState(0);
  const [page, setPage] = useState(1);

  useEffect(() => {
    fetch(`http://localhost:8080/api/book/data/get-book?page=${page}`)
      .then((response) => response.json())
      .then((data) => setBooks([...data]))
      .catch((error) => console.error("Error fetching books:", error));
  }, [page]);

  return (
    <div className="main-panel">
      <div className="data">
        <div className="grid-item">
          <h2 className="grid-title">List of books:</h2>
          <BookList books={books} setActive={setActive} />
        </div>
        <div className="grid-item">
          <h2 className="grid-title">Book detail:</h2>
          <BookDetail detail={active} />
        </div>
      </div>
      <PagePanel page={page} setPage={setPage} setBooks={setBooks} />
    </div>
  );
}

function BookList({ books, active, setActive }) {
  return (
    <div className="book-list">
      {books.map((book) => (
        <BookItem
          bookItem={book}
          // key={book.id}
          active={active}
          setActive={setActive}
        />
      ))}
    </div>
  );
}

function BookItem({ bookItem, key, active, setActive }) {
  function handleSelect(id) {
    setActive((active) => bookItem);
  }

  return (
    <div className="item" onClick={handleSelect}>
      <h3 className="item-title">{bookItem.book_title}</h3>
    </div>
  );
}

function BookDetail({ detail }) {
  return (
    <div className="book-detail">
      <p className="detail-isbn">ISBN: {detail.isbn}</p>
      <h2 className="detail-title">{detail.book_title}</h2>
      <p className="detail-p">Author: {detail.book_author}</p>
      <p className="detail-p">Publication year: {detail.year_of_publication}</p>
      <p className="detail-p">Publisher: {detail.publisher}</p>
      <img
        className="detail-img"
        alt="book_cover"
        src={`${detail.image_url_m}`}
      />
    </div>
  );
}

function PagePanel({ page, setPage, setBooks }) {
  function handleNextPage() {
    setPage((page) => page + 1);
  }

  function handlePrevPage() {
    if (page > 1) setPage((page) => page - 1);
  }

  return (
    <div className="page-panel">
      <button className="btn page-btn" onClick={handlePrevPage}>{`<`}</button>
      <input className="page-text" type="text" value={page} />
      <button className="btn page-btn" onClick={handleNextPage}>{`>`}</button>
    </div>
  );
}
