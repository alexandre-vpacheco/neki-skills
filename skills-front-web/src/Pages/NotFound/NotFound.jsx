import './Notfound.css'
import ImgNotFound from '../../assets/paginas_NotFound.png'

export default function NotFound() {

    return (
        <div className='image-container'>
            <img src={ImgNotFound} alt="Página não encontrada" className='imagemNotFound' />
        </div>
    )
}