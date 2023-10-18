package org.example;

import java.util.ArrayList;
import java.util.List;

public record OrderInformation (String name, List<Product> products, boolean isFriday){}

