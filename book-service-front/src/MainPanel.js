import BookDetail from "./BookDetail";
import BookList from "./BookList";

export default function MainPanel({ books }) {
  return (
    <div className="main-panel">
      <BookList booksArr={books} />
      <BookDetail />
    </div>
  );
}
