import PicturegramClient from '../api/picturegramClient';
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from '../util/DataStore';

/**
 * Logic needed for the create playlist page of the website.
 */
class CreateImage extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'submit', 'redirectToViewImage'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.redirectToViewPlaylist);
        this.header = new Header(this.dataStore);
    }

    /**
     * Add the header to the page and load the MusicPlaylistClient.
     */
    mount() {
        document.getElementById('create').addEventListener('click', this.submit);

        this.header.addHeaderToPage();

        this.client = new PicturegramClient();
    }

    /**
     * Method to run when the create playlist submit button is pressed. Call the MusicPlaylistService to create the
     * playlist.
     */
    async submit() {
        const errorMessageDisplay = document.getElementById('error-message');
        errorMessageDisplay.innerText = ``;
        errorMessageDisplay.classList.add('hidden');

        const uploadButton = document.getElementById('Upload');
        const origButtonText = createButton.innerText;
        uploadButton.innerText = 'Loading...';

        const imageUrl = document.getElementById('imageUrl').value;
        const caption = document.getElementById('caption').value;

        let tags;
        if (tagsText.length < 1) {
            tags = null;
        } else {
            tags = tagsText.split(/\s*,\s*/);
        }

        const image = await this.client.createImage(imageUrl, caption, (error) => {
            uploadButton.innerText = origButtonText;
            errorMessageDisplay.innerText = `Error: ${error.message}`;
            errorMessageDisplay.classList.remove('hidden');
        });
        this.dataStore.set('Image', image);
    }

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const createPlaylist = new CreatePlaylist();
    createPlaylist.mount();
};

window.addEventListener('DOMContentLoaded', main);
