import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import App from './App.jsx';
import Detail from './Detail.jsx';
import Input from './Input.jsx';
import { BrowserRouter, Routes, Route } from "react-router-dom";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/detail" element={<Detail />} />
        <Route path="/input" element={<Input />} />
      </Routes>
    </BrowserRouter>
  </StrictMode>,
);