export default function BookItem({ bookItem, key }) {
  return (
    <div className="item">
      <p className="item-title">{bookItem.title}</p>
      <p className="item-author">| {bookItem.authors[0]}</p>
      <button className="btn item-btn">{`>`}</button>
    </div>
  );
}
