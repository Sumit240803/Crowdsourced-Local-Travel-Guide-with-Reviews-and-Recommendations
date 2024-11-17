"use client"
import React, { useState } from 'react'

const Search: React.FC = () => {
  const [query, setQuery] = useState<string>("");

  const handleSearch = (event: React.FormEvent) => {
    event.preventDefault();
    // You can handle the search logic here (e.g., making an API request)
    console.log("Searching for:", query);
  };

  return (
    <div className="flex justify-center items-center">
      <form onSubmit={handleSearch} className="flex space-x-2">
        {/* Search Input */}
        <input
          type="text"
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          placeholder="Search..."
          className="p-2 rounded-l-md border-2 border-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-400"
        />

        {/* Search Button */}
        <button
          type="submit"
          className="bg-blue-600 text-white px-4 py-2 rounded-r-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-400"
        >
          Search
        </button>
      </form>
    </div>
  );
};

export default Search;
