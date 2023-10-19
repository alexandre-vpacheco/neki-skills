import './App.css';
import Rotas from './Routes/Routes';
import { BrowserRouter, Route } from 'react-router-dom';

function App() {

  return (
    <BrowserRouter>
      <div className='content-container' style={{ minHeight: 'calc(100vh - 350px)' }}>
        <Rotas />
      </div>
    </BrowserRouter>
  )
}

export default App
