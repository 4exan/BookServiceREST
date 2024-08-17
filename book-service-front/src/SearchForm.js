export default function SearchForm() {
  function handleSubmit(e) {
    e.preventDefault();
  }

  return (
    <div className="center">
      <form className="search-form">
        <input type="text" placeholder="Search" className="search-input" />
        <button className="btn-search" onClick={handleSubmit}>
          Search
        </button>
      </form>
    </div>
  );
}
