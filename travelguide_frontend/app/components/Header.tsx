"use client"
import Link from 'next/link';
import React, { useState } from 'react'
import Search from './Search';

const Header: React.FC = () => {
  const [isLoggedIn, setIsLoggedIn] = useState<boolean>(false);

  return (
    <nav className="bg-blue-600">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between items-center h-16">
          {/* Logo */}
          <div className="flex items-center space-x-4">
            <Link href="/" className="text-white font-bold text-xl">
              Tripper
            </Link>
          </div>

          {/* Search Component - Centered for Desktop and Mobile */}
         

          {/* Desktop View (larger screens) */}
          <div className="hidden md:flex space-x-4 items-center">
            {/* Conditional Rendering of User Profile or Login Button */}
            {isLoggedIn ? (
              <Link href="/profile" className="rounded-full bg-white w-10 h-10">
                {/* Profile Icon */}
                <img src="/profile-icon.jpg" alt="User" className="w-8 h-8 rounded-full" />
              </Link>
            ) : (
              <button
                onClick={() => setIsLoggedIn(true)} // Example login button
                className="text-white hover:text-gray-300"
              >
                Login
              </button>
            )}
          </div>

          {/* Mobile View (small screens) */}
          <div className="flex md:hidden items-center space-x-4">
           
          

            {/* Conditional Rendering of User Profile or Login Button for Mobile */}
            {isLoggedIn ? (
              <Link href="/profile" className="rounded-full bg-white w-10 h-10">
                {/* Profile Icon */}
                <img src="/profile-icon.jpg" alt="User" className="w-8 h-8 rounded-full" />
              </Link>
            ) : (
              <button
                onClick={() => setIsLoggedIn(true)} // Example login button
                className="text-white hover:text-gray-300"
              >
                Login
              </button>
            )}
          </div>
        </div>
      </div>
    </nav>
  );
}

export default Header;
