import { useState } from "react";
import BookDetail from "./Book/BookDetail";
import BookList from "./Book/BookList";
import SearchForm from "./SearchForm";

export default function MainPanel({ books }) {
  const [details, setDetails] = useState(books[0]);

  return (
    <div className="main-panel">
      <SearchForm />
      <div className="main-panel data">
        <BookList booksArr={books} details={details} setDetails={setDetails} />
        <BookDetail bookDetails={details} />
      </div>
    </div>
  );
}
