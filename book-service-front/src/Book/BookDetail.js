export default function BookDetail({ bookDetails }) {
  if (!bookDetails) return <p>Select any book!</p>;

  const authors = bookDetails.authors;

  return (
    <div className="book-detail">
      <h2 className="detail-title">{bookDetails.title}</h2>
      <p>Authors: {authors.map((author) => `${author} `)}</p>
      <p>Isbn: {bookDetails.isbn}</p>
      <p>Page count: {bookDetails.pageCount}</p>
      <p>
        Categories: (
        {bookDetails.categories.map((category) =>
          bookDetails.categories.lenght === 1 ? `${category}` : `${category},`
        )}
        )
      </p>
      <p>Short description: {bookDetails.shortDescription}</p>
      <p>ID: {bookDetails.id}</p>
      <img className="detail-img" src={bookDetails.thumbnailUrl} alt="book" />
    </div>
  );
}
