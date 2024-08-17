import BookItem from "./BookItem";

export default function BookList({ booksArr, details, setDetails }) {
  if (booksArr.lenght === 0) console.log(123);

  return (
    <div className="book-list">
      <ul>
        {booksArr.map((book) => (
          <BookItem
            bookItem={book}
            key={book._id}
            details={details}
            setDetails={setDetails}
          />
        ))}
      </ul>
    </div>
  );
}
