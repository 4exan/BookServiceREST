import { useEffect, useState } from "react";

export default function MainPanel() {
  const [books, setBooks] = useState([]);
  const [active, setActive] = useState(0);
  const [page, setPage] = useState(0);
  const [search, setSearch] = useState("");

  useEffect(() => {
    fetch(
      `http://localhost:8080/api/book/data/get-book/search?page=${page}&title=${search}`
    )
      .then((response) => response.json())
      .then((data) => setBooks(data.content))
      .catch((error) => console.error("Error fetching books:", error));
  }, [page, search]);

  return (
    <div className="main-panel">
      <div className="search-form">
        <input
          type="text"
          className="search-input"
          placeholder="Search"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
      </div>
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
      <PagePanel
        page={page}
        setPage={setPage}
        setBooks={setBooks}
        search={search}
      />
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

function PagePanel({ page, setPage, setBooks, search }) {
  function handleNextPage() {
    setPage((page) => page + 1);
  }

  function handlePrevPage() {
    setPage((page) => page - 1);
  }

  return (
    <div className="page-panel" disabled={search !== ""}>
      <button
        className="btn page-btn"
        onClick={handlePrevPage}
        disabled={page === 0}
      >{`<`}</button>
      <input className="page-text" type="text" value={page} />
      <button className="btn page-btn" onClick={handleNextPage}>{`>`}</button>
    </div>
  );
}
