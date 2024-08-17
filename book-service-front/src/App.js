import Navbar from "./Navbar";
import MainPanel from "./MainPanel";
import { useState } from "react";
import getBooks from "./BookDatabase";

export default function App() {
  const booksArr = [
    {
      id: 1,
      title: "Guards! Guards!",
      author: "Terry Pratchett",
      isbn: "0-575-04606-6",
      publisher: "Gollancz",
    },
    {
      id: 2,
      title: "His Dark Materials",
      author: "Philip Pullman",
      isbn: "9780345448897",
      publisher: "Scholastic",
    },
    {
      id: 3,
      title: "The Hitchhiker's Guide to the Galaxy",
      author: "Douglas Adams",
      isbn: "0-330-25864-8",
      publisher: "Pan Books",
    },
  ];
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
