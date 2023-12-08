package edu.pvr.concepts.serializable;

import edu.pvr.concepts.common.utils.ConsoleUtil;
import edu.pvr.concepts.serializable.dto.PersonV1Dto;
import edu.pvr.concepts.serializable.dto.PersonV2Dto;

import static edu.pvr.concepts.serializable.SerializationUtil.deserializeFromFile;
import static edu.pvr.concepts.serializable.SerializationUtil.serializeToFile;

public class UseOfSerializableUid {


    private static void serializeData() {
        String dirPath = "tmp";

        PersonV1Dto personV1Dto = new PersonV1Dto("Pranav", 313123213);
        serializeToFile(personV1Dto, dirPath, "personv1.text");

        PersonV2Dto personV2Dto = new PersonV2Dto("Pranav", "313123213");
        serializeToFile(personV2Dto, dirPath, "personv2.text");
    }

    private static void deserializeData() {
        String dirPath = "tmp";
        PersonV1Dto personV1 = deserializeFromFile(PersonV1Dto.class, dirPath, "personv1.text");

        if (personV1 != null) {
            ConsoleUtil.success("PersonV1 deserialized: " + personV1);
        } else {
            ConsoleUtil.danger("Error deserializing the PersonV1 object.");
        }

        PersonV2Dto personV2 = deserializeFromFile(PersonV2Dto.class, dirPath, "personv2.text");

        if (personV2 != null) {
            ConsoleUtil.success("PersonV2 deserialized: " + personV2);
        } else {
            ConsoleUtil.danger("Error deserializing the personV2 object.");
        }
    }

    /**
     * Fir serialize data with 1L for person. Then change UID to 3L in that class.
     * Commnet serializeData and uncommnet deserializeData.  It will show below error.
     * java.io.InvalidClassException: edu.pvr.concepts.serializable.dto.PersonV1Dto;
     * local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 3
     *
     * @param args
     */
    public static void main(String[] args) {
//        serializeData();
        deserializeData();

    }
}
