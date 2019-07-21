package tw.noel.sung.com.demo_huskybundle;

import android.os.Parcel;
import android.os.Parcelable;

public class TestModel implements Parcelable {


    /**
     * name : noel
     * age : 20
     */

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    public TestModel() {
    }

    protected TestModel(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel source) {
            return new TestModel(source);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };
}
