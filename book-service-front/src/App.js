import Navbar from "./Navbar";
import MainPanel from "./MainPanel";
import { useState } from "react";
import getBooks from "./Book/BookDatabase";

export default function App() {
  const [books, setBooks] = useState(getBooks);

  function handleAddBooks() {
    setBooks((book) => [...books, book]);
  }

  return (
    <div>
      <Navbar />
      <MainPanel books={books} />
    </div>
  );
}
