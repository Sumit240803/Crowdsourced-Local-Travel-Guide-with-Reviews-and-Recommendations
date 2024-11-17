import Image from "next/image";
import Header from "./components/Header";
import Search from "./components/Search";

export default function Home() {
  return (
    <>
    <div>
    <Header/>
    </div>
    <div className="mt-4">
    <Search/>
    </div>
    </>
  );
}
