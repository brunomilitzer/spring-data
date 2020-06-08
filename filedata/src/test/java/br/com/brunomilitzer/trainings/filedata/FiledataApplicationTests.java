package br.com.brunomilitzer.trainings.filedata;

import br.com.brunomilitzer.trainings.filedata.model.Image;
import br.com.brunomilitzer.trainings.filedata.repository.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
class FiledataApplicationTests {

    @Autowired
    private ImageRepository repository;

    @Test
    public void testImageSave() throws IOException {

        final File file = new File("C:\\Users\\bruno\\IdeaProjects\\springdata\\filedata\\src\\images\\2020-05-13-0001.jpg");

        final byte[] fileContent = new byte[(int) file.length()];

        final FileInputStream ips = new FileInputStream(file);
        ips.read(fileContent);

        final Image image = new Image();
        image.setId(1L);
        image.setName("20190526_160742.JPG");
        image.setData(fileContent);

        this.repository.save(image);

        ips.close();
    }

    @Test
    public void testImageRead() {

        final Image image = this.repository.findById(1L).orElse(null);

        if (image != null) {

            final File file = new File("C:\\Users\\bruno\\IdeaProjects\\springdata\\filedata\\src\\saves\\" + image.getName());

            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream(file);
                fos.write(image.getData());
            } catch (final IOException e) {
                e.printStackTrace();
            } finally {
                
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
