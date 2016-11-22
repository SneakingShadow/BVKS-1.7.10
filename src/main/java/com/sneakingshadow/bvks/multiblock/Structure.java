package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
class Structure {

    private ArrayList<ArrayList<ArrayList<StructureBlock>>> structure = new ArrayList<ArrayList<ArrayList<StructureBlock>>>();

    Structure() {
        structure.add(new ArrayList<ArrayList<StructureBlock>>());
        structure.get(0).add(new ArrayList<StructureBlock>());
        structure.get(0).get(0).add(null);
    }


    void set(int x, int y, int z, StructureBlock structureBlock) {
        ensureCapacity(x,y,z);
        structure.get(x).get(y).set(z, structureBlock);
    }

    StructureBlock get(int x, int y, int z) {
        if (x < sizeX() || y < sizeY() || z < sizeZ())
            return null;
        return structure.get(x).get(y).get(z);
    }


    private void ensureCapacity(int x, int y, int z) {
        boolean x_bool = x < sizeX();
        boolean y_bool = y < sizeY();
        boolean z_bool = z < sizeZ();

        //Doesn't need to go through anything
        if (x_bool && y_bool && z_bool)
            return;

        //Doesn't need to go through x array unless y array or z array are too small
        if (y_bool || z_bool)
            //Go through and ensure current x array
            for (int ix = 0; ix < sizeX(); ix++)
            {
                //Doesn't need to go through y array unless z is too small
                if (z_bool)
                    for (int iy = 0; iy < sizeY(); iy++)
                        //Ensure z array
                        for (int iz = sizeZ(); iz < z + 1; iz++)
                            structure.get(ix).get(iy).add(null);

                //Ensure y array. Doesn't need to check if y_bool, as iy < y+1 serves this function
                for (int iy = sizeY(); iy < y + 1; iy++)
                    structure.get(ix).add(getEmptyArray(z));
            }

        //Ensure structure
        for (int ix = sizeX(); ix < x+1; ix++)
            structure.add(getEmptyArray(y, z));
    }

    private int sizeX() {
        return structure.size();
    }

    private int sizeY() {
        return structure.get(0).size();
    }

    private int sizeZ() {
        return structure.get(0).get(0).size();
    }

    private int maxX(int x) {
        return Math.max(x+1, sizeX());
    }

    private int maxY(int y) {
        return Math.max(y+1, sizeY());
    }

    private int maxZ(int z) {
        return Math.max(z+1, sizeZ());
    }

    private ArrayList<StructureBlock> getEmptyArray(int z) {
        ArrayList<StructureBlock> arrayList = new ArrayList<StructureBlock>();
        for (int iz = 0; iz < maxZ(z); iz++) {
            arrayList.add(null);
        }
        return arrayList;
    }

    private ArrayList<ArrayList<StructureBlock>> getEmptyArray(int y, int z) {
        ArrayList<ArrayList<StructureBlock>> arrayList = new ArrayList<ArrayList<StructureBlock>>();
        for (int iy = 0; iy < maxY(y); iy++) {
            arrayList.add(getEmptyArray(z));
        }
        return arrayList;
    }
}
