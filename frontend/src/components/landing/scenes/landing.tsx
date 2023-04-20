import Home from "./home";
import { useEffect, useState } from "react";
import { SelectedPage } from "../shared/types";

function App() {
  const [selectedPage, setSelectedPage] = useState<SelectedPage>(
    SelectedPage.Home
  );
  

  return (
    <div className="app bg-gray-20">
      <Home setSelectedPage={setSelectedPage} />
    </div>
  );
}

export default App;
