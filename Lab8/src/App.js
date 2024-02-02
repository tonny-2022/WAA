
import Dashboard from "./Components/Dashboard/Dashboard"
import './App.css';
import { useState } from "react";
import { appContext } from "./AppContext"


function App() {
  const[productId,setProductId]=useState(0);
  return (
    <appContext.Provider value={{productId,setProductId}}>
    <div className='app_div'>
       
      <Dashboard/>
      
    </div>
    </appContext.Provider>
  );
}

export default App;
