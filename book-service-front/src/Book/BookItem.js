export default function BookItem({ bookItem, key, details, setDetails }) {
  function handleSelectBook(id) {
    setDetails((details) => bookItem);
    console.log(`Selected book! ${bookItem.title}`);
  }

  return (
    <div
      className={`item ${bookItem.id === details.id ? `selected` : ""}`}
      onClick={handleSelectBook}
    >
      <p className="item-title">{bookItem.title}</p>
      <button className="btn item-btn">&rArr;</button>
    </div>
  );
}
