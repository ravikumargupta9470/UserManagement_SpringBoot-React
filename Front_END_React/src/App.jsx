import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Home from './Component/Home'
import Headers from './Component/Header'
import Footer from './Component/Footer'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import InsertData from './Component/InsertData'
import UpdataData from './Component/UpdataData'

function App() {


  return (
    <>

      <div>
        <BrowserRouter>
          <Headers />
          <Routes>
            <Route path="/" element={<Home />} />

            <Route path="/home" element={<Home />} />
            <Route path="/insert" element={<InsertData />} />
            <Route path="/updatedata/:id" element={<UpdataData />} />

          </Routes>

        </BrowserRouter>

        {/* <Footer /> */}
      </div>
    </>
  )
}

export default App
